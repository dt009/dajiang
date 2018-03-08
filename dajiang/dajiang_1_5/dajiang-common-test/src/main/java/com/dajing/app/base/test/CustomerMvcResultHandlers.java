package com.dajing.app.base.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.PrintingResultHandler;
import org.springframework.util.CollectionUtils;

import java.io.*;

public class CustomerMvcResultHandlers extends MockMvcResultHandlers {

    private static final Log logger = LogFactory.getLog("org.springframework.test.web.servlet.result");

    /**
     * Log {@link MvcResult} details as a {@code DEBUG} log message via
     * Apache Commons Logging using the log category
     * {@code org.springframework.test.web.servlet.result}.
     *
     * @see #print()
     * @see #print(OutputStream)
     * @see #print(Writer)
     * @since 4.2
     */
    public static ResultHandler log() {
        return new CustomerMvcResultHandlers.LoggingResultHandler();
    }

    /**
     * Print {@link MvcResult} details to the "standard" output stream.
     *
     * @see System#out
     * @see #print(OutputStream)
     * @see #print(Writer)
     * @see #log()
     */
    public static ResultHandler print() {
        return print(System.out);
    }

    /**
     * Print {@link MvcResult} details to the supplied {@link OutputStream}.
     *
     * @see #print()
     * @see #print(Writer)
     * @see #log()
     * @since 4.2
     */
    public static ResultHandler print(OutputStream stream) {
        return new CustomerMvcResultHandlers.PrintWriterPrintingResultHandler(new PrintWriter(stream, true));
    }

    /**
     * Print {@link MvcResult} details to the supplied {@link Writer}.
     *
     * @see #print()
     * @see #print(OutputStream)
     * @see #log()
     * @since 4.2
     */
    public static ResultHandler print(Writer writer) {
        return new CustomerMvcResultHandlers.PrintWriterPrintingResultHandler(new PrintWriter(writer, true));
    }


    /**
     * A {@link PrintingResultHandler} that writes to a {@link PrintWriter}.
     */
    private static class PrintWriterPrintingResultHandler extends PrintingResultHandler {

        public PrintWriterPrintingResultHandler(final PrintWriter writer) {
            super(new PrintingResultHandler.ResultValuePrinter() {
                @Override
                public void printHeading(String heading) {
                    writer.println();
                    writer.println(String.format("%s:", heading));
                }

                @Override
                public void printValue(String label, Object value) {
                    if (value != null && value.getClass().isArray()) {
                        value = CollectionUtils.arrayToList(value);
                    }
                    writer.println(String.format("%17s = %s", label, value));
                }
            });
        }

        @Override
        protected void printRequest(MockHttpServletRequest request) throws Exception {
            this.getPrinter().printValue("HTTP Method", request.getMethod());
            this.getPrinter().printValue("Request URI", request.getRequestURI());
            this.getPrinter().printValue("Parameters", getParamsMultiValueMap(request));
            this.getPrinter().printValue("Headers", getRequestHeaders(request));
            this.getPrinter().printValue("Body", getContentAsString(request));
        }

        private String getContentAsString(MockHttpServletRequest request) throws IOException {
            BufferedReader reader = request.getReader();
            StringBuilder builder = new StringBuilder();
            String aux;
            while ((aux = reader.readLine()) != null) {
                builder.append(aux);
            }
            return builder.toString();
        }
    }


    /**
     * A {@link ResultHandler} that logs {@link MvcResult} details at
     * {@code DEBUG} level via Apache Commons Logging.
     * <p>
     * <p>Delegates to a {@link MockMvcResultHandlers.PrintWriterPrintingResultHandler} for
     * building the log message.
     *
     * @since 4.2
     */
    private static class LoggingResultHandler implements ResultHandler {

        @Override
        public void handle(MvcResult result) throws Exception {
            if (logger.isDebugEnabled()) {
                StringWriter stringWriter = new StringWriter();
                ResultHandler printingResultHandler =
                        new CustomerMvcResultHandlers.PrintWriterPrintingResultHandler(new PrintWriter(stringWriter));
                printingResultHandler.handle(result);
                logger.debug("MvcResult details:\n" + stringWriter);
            }
        }
    }


}

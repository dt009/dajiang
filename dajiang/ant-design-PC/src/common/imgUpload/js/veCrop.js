// hidpi-canvas.js
/********************************************* */

/**
 * HiDPI Canvas Polyfill (1.0.9)
 *
 * Author: Jonathan D. Johnson (http://jondavidjohn.com)
 * Homepage: https://github.com/jondavidjohn/hidpi-canvas-polyfill
 * Issue Tracker: https://github.com/jondavidjohn/hidpi-canvas-polyfill/issues
 * License: Apache 2.0
 */
(function(prototype) {
    
        var pixelRatio = (function(context) {
                    // context.webkitBackingStorePixelRatio ||
                var backingStore = context.backingStorePixelRatio ||
                    context.mozBackingStorePixelRatio ||
                    context.msBackingStorePixelRatio ||
                    context.oBackingStorePixelRatio ||
                    context.backingStorePixelRatio || 1;
    
                return (window.devicePixelRatio || 1) / backingStore;
            })(prototype),
    
            forEach = function(obj, func) {
                for (var p in obj) {
                    if (obj.hasOwnProperty(p)) {
                        func(obj[p], p);
                    }
                }
            },
    
            ratioArgs = {
                'fillRect': 'all',
                'clearRect': 'all',
                'strokeRect': 'all',
                'moveTo': 'all',
                'lineTo': 'all',
                'arc': [0,1,2],
                'arcTo': 'all',
                'bezierCurveTo': 'all',
                'isPointinPath': 'all',
                'isPointinStroke': 'all',
                'quadraticCurveTo': 'all',
                'rect': 'all',
                'translate': 'all',
                'createRadialGradient': 'all',
                'createLinearGradient': 'all'
            };
    
        if (pixelRatio === 1) return;
    
        forEach(ratioArgs, function(value, key) {
            prototype[key] = (function(_super) {
                return function() {
                    var i, len,
                        args = Array.prototype.slice.call(arguments);
    
                    if (value === 'all') {
                        args = args.map(function(a) {
                            return a * pixelRatio;
                        });
                    }
                    else if (Array.isArray(value)) {
                        for (i = 0, len = value.length; i < len; i++) {
                            args[value[i]] *= pixelRatio;
                        }
                    }
    
                    return _super.apply(this, args);
                };
            })(prototype[key]);
        });
    
        // Stroke lineWidth adjustment
        prototype.stroke = (function(_super) {
            return function() {
                this.lineWidth *= pixelRatio;
                _super.apply(this, arguments);
                this.lineWidth /= pixelRatio;
            };
        })(prototype.stroke);
    
        // Text
        //
        prototype.fillText = (function(_super) {
            return function() {
                var args = Array.prototype.slice.call(arguments);
    
                args[1] *= pixelRatio; // x
                args[2] *= pixelRatio; // y
    
                this.font = this.font.replace(
                    /(\d+)(px|em|rem|pt)/g,
                    function(w, m, u) {
                        return (m * pixelRatio) + u;
                    }
                );
    
                _super.apply(this, args);
    
                this.font = this.font.replace(
                    /(\d+)(px|em|rem|pt)/g,
                    function(w, m, u) {
                        return (m / pixelRatio) + u;
                    }
                );
            };
        })(prototype.fillText);
    
        prototype.strokeText = (function(_super) {
            return function() {
                var args = Array.prototype.slice.call(arguments);
    
                args[1] *= pixelRatio; // x
                args[2] *= pixelRatio; // y
    
                this.font = this.font.replace(
                    /(\d+)(px|em|rem|pt)/g,
                    function(w, m, u) {
                        return (m * pixelRatio) + u;
                    }
                );
    
                _super.apply(this, args);
    
                this.font = this.font.replace(
                    /(\d+)(px|em|rem|pt)/g,
                    function(w, m, u) {
                        return (m / pixelRatio) + u;
                    }
                );
            };
        })(prototype.strokeText);
    })(CanvasRenderingContext2D.prototype);
    ;(function(prototype) {
        prototype.getContext = (function(_super) {
            return function(type) {
                var backingStore, ratio,
                    context = _super.call(this, type);
    
                if (type === '2d') {
    
                        // context.webkitBackingStorePixelRatio ||
                    backingStore = context.backingStorePixelRatio ||
                        context.mozBackingStorePixelRatio ||
                        context.msBackingStorePixelRatio ||
                        context.oBackingStorePixelRatio ||
                        context.backingStorePixelRatio || 1;
    
                    ratio = (window.devicePixelRatio || 1) / backingStore;
    
                    if (ratio > 1) {
                        this.style.height = this.height + 'px';
                        this.style.width = this.width + 'px';
                        this.width *= ratio;
                        this.height *= ratio;
                    }
                }
    
                return context;
            };
        })(prototype.getContext);
    })(HTMLCanvasElement.prototype);
    

/********************************************* */

// touch.js
/********************************************* */

/*! touchjs v0.2.14  2014-08-05 */
'use strict';
(function(root, factory) {
    console.log("afasfasfasf");
    // if (typeof define === 'function' && (define.amd || define.cmd)) {
    //     define(factory); //Register as a module.
    //     console.log("fifififif 213123");
    // } else {
    //     console.log("213123");
        window.touch = factory();
    // }
}(this, function() {

    var utils = {};

    utils.PCevts = {
        'touchstart': 'mousedown',
        'touchmove': 'mousemove',
        'touchend': 'mouseup',
        'touchcancel': 'mouseout'
    };

    utils.hasTouch = ('ontouchstart' in window);

    utils.getType = function(obj) {
        return Object.prototype.toString.call(obj).match(/\s([a-z|A-Z]+)/)[1].toLowerCase();
    };

    utils.getSelector = function(el) {
        if (el.id) {
            return "#" + el.id;
        }
        if (el.className) {
            var cns = el.className.split(/\s+/);
            return "." + cns.join(".");
        } else if (el === document) {
            return "body";
        } else {
            return el.tagName.toLowerCase();
        }
    };

    utils.matchSelector = function(target, selector) {
        return target.webkitMatchesSelector(selector);
    };

    utils.getEventListeners = function(el) {
        return el.listeners;
    };

    utils.getPCevts = function(evt) {
        return this.PCevts[evt] || evt;
    };

    utils.forceReflow = function() {
        var tempDivID = "reflowDivBlock";
        var domTreeOpDiv = document.getElementById(tempDivID);
        if (!domTreeOpDiv) {
            domTreeOpDiv = document.createElement("div");
            domTreeOpDiv.id = tempDivID;
            document.body.appendChild(domTreeOpDiv);
        }
        var parentNode = domTreeOpDiv.parentNode;
        var nextSibling = domTreeOpDiv.nextSibling;
        parentNode.removeChild(domTreeOpDiv);
        parentNode.insertBefore(domTreeOpDiv, nextSibling);
    };

    utils.simpleClone = function(obj) {
        return Object.create(obj);
    };

    utils.getPosOfEvent = function(ev) {
        if (this.hasTouch) {
            var posi = [];
            var src = null;

            for (var t = 0, len = ev.touches.length; t < len; t++) {
                src = ev.touches[t];
                posi.push({
                    x: src.pageX,
                    y: src.pageY
                });
            }
            return posi;
        } else {
            return [{
                x: ev.pageX,
                y: ev.pageY
            }];
        }
    };

    utils.getDistance = function(pos1, pos2) {
        var x = pos2.x - pos1.x,
            y = pos2.y - pos1.y;
        return Math.sqrt((x * x) + (y * y));
    };

    utils.getFingers = function(ev) {
        return ev.touches ? ev.touches.length : 1;
    };

    utils.calScale = function(pstart, pmove) {
        if (pstart.length >= 2 && pmove.length >= 2) {
            var disStart = this.getDistance(pstart[1], pstart[0]);
            var disEnd = this.getDistance(pmove[1], pmove[0]);

            return disEnd / disStart;
        }
        return 1;
    };

    utils.getAngle = function(p1, p2) {
        return Math.atan2(p2.y - p1.y, p2.x - p1.x) * 180 / Math.PI;
};

    utils.getAngle180 = function(p1, p2) {
        var agl = Math.atan((p2.y - p1.y) * -1 / (p2.x - p1.x)) * (180 / Math.PI);
        return (agl < 0 ? (agl + 180) : agl);
    };

    utils.getDirectionFromAngle = function(agl) {
        var directions = {
            up: agl < -45 && agl > -135,
            down: agl >= 45 && agl < 135,
            left: agl >= 135 || agl <= -135,
            right: agl >= -45 && agl <= 45
        };
        for (var key in directions) {
            if (directions[key]) return key;
        }
        return null;
    };

    utils.getXYByElement = function(el) {
        var left = 0,
            top = 0;

        while (el.offsetParent) {
            left += el.offsetLeft;
            top += el.offsetTop;
            el = el.offsetParent;
        }
        return {
            left: left,
            top: top
        };
    };

    utils.reset = function() {
        startEvent = moveEvent = endEvent = null;
        __tapped = __touchStart = startSwiping = startPinch = false;
        startDrag = false;
        pos = {};
        __rotation_single_finger = false;
    };

    utils.isTouchMove = function(ev) {
        return (ev.type === 'touchmove' || ev.type === 'mousemove');
    };

    utils.isTouchEnd = function(ev) {
        return (ev.type === 'touchend' || ev.type === 'mouseup' || ev.type === 'touchcancel');
    };

    utils.env = (function() {
        var os = {}, ua = navigator.userAgent,
            android = ua.match(/(Android)[\s\/]+([\d\.]+)/),
            ios = ua.match(/(iPad|iPhone|iPod)\s+OS\s([\d_\.]+)/),
            wp = ua.match(/(Windows\s+Phone)\s([\d\.]+)/),
            isWebkit = /WebKit\/[\d.]+/i.test(ua),
            isSafari = ios ? (navigator.standalone ? isWebkit : (/Safari/i.test(ua) && !/CriOS/i.test(ua) && !/MQQBrowser/i.test(ua))) : false;
        if (android) {
            os.android = true;
            os.version = android[2];
        }
        if (ios) {
            os.ios = true;
            os.version = ios[2].replace(/_/g, '.');
            os.ios7 = /^7/.test(os.version);
            if (ios[1] === 'iPad') {
                os.ipad = true;
            } else if (ios[1] === 'iPhone') {
                os.iphone = true;
                os.iphone5 = screen.height == 568;
            } else if (ios[1] === 'iPod') {
                os.ipod = true;
            }
        }
        if (wp) {
            os.wp = true;
            os.version = wp[2];
            os.wp8 = /^8/.test(os.version);
        }
        if (isWebkit) {
            os.webkit = true;
        }
        if (isSafari) {
            os.safari = true;
        }
        return os;
    })();

    /** 底层事件绑定/代理支持  */
    var engine = {
        proxyid: 0,
        proxies: [],
        trigger: function(el, evt, detail) {

            detail = detail || {};
            var e, opt = {
                bubbles: true,
                cancelable: true,
                detail: detail
            };

            try {
                if (typeof CustomEvent !== 'undefined') {
                    e = new CustomEvent(evt, opt);
                    if (el) {
                        el.dispatchEvent(e);
                    }
                } else {
                    e = document.createEvent("CustomEvent");
                    e.initCustomEvent(evt, true, true, detail);
                    if (el) {
                        el.dispatchEvent(e);
                    }
                }
            } catch (ex) {
                console.warn("Touch.js is not supported by environment.");
            }
        },
        bind: function(el, evt, handler) {
            el.listeners = el.listeners || {};
            if (!el.listeners[evt]) {
                el.listeners[evt] = [handler];
            } else {
                el.listeners[evt].push(handler);
            }
            var proxy = function(e) {
                if (utils.env.ios7) {
                    utils.forceReflow();
                }
                e.originEvent = e;
                for (var p in e.detail) {
                    if (p !== 'type') {
                        e[p] = e.detail[p];
                    }
                }
                e.startRotate = function() {
                    __rotation_single_finger = true;
                };
                var returnValue = handler.call(e.target, e);
                if (typeof returnValue !== "undefined" && !returnValue) {
                    e.stopPropagation();
                    e.preventDefault();
                }
            };
            handler.proxy = handler.proxy || {};
            if (!handler.proxy[evt]) {
                handler.proxy[evt] = [this.proxyid++];
            } else {
                handler.proxy[evt].push(this.proxyid++);
            }
            this.proxies.push(proxy);
            if (el.addEventListener) {
                el.addEventListener(evt, proxy, false);
            }
        },
        unbind: function(el, evt, handler) {
            if (!handler) {
                var handlers = el.listeners[evt];
                if (handlers && handlers.length) {
                    handlers.forEach(function(handler) {
                        el.removeEventListener(evt, handler, false);
                    });
                }
            } else {
                var proxyids = handler.proxy[evt];
                if (proxyids && proxyids.length) {
                    proxyids.forEach(function(proxyid) {
                        if (el.removeEventListener) {
                            el.removeEventListener(evt, this.proxies[this.proxyid], false);
                        }
                    });
                }
            }
        },
        delegate: function(el, evt, sel, handler) {
            var proxy = function(e) {
                var target, returnValue;
                e.originEvent = e;
                for (var p in e.detail) {
                    if (p !== 'type') {
                        e[p] = e.detail[p];
                    }
                }
                e.startRotate = function() {
                    __rotation_single_finger = true;
                };
                var integrateSelector = utils.getSelector(el) + " " + sel;
                var match = utils.matchSelector(e.target, integrateSelector);
                var ischild = utils.matchSelector(e.target, integrateSelector + " " + e.target.nodeName);
                if (!match && ischild) {
                    if (utils.env.ios7) {
                        utils.forceReflow();
                    }
                    target = e.target;
                    while (!utils.matchSelector(target, integrateSelector)) {
                        target = target.parentNode;
                    }
                    returnValue = handler.call(e.target, e);
                    if (typeof returnValue !== "undefined" && !returnValue) {
                        e.stopPropagation();
                        e.preventDefault();
                    }
                } else {
                    if (utils.env.ios7) {
                        utils.forceReflow();
                    }
                    if (match || ischild) {
                        returnValue = handler.call(e.target, e);
                        if (typeof returnValue !== "undefined" && !returnValue) {
                            e.stopPropagation();
                            e.preventDefault();
                        }
                    }
                }
            };
            handler.proxy = handler.proxy || {};
            if (!handler.proxy[evt]) {
                handler.proxy[evt] = [this.proxyid++];
            } else {
                handler.proxy[evt].push(this.proxyid++);
            }
            this.proxies.push(proxy);
            el.listeners = el.listeners || {};
            if (!el.listeners[evt]) {
                el.listeners[evt] = [proxy];
            } else {
                el.listeners[evt].push(proxy);
            }
            if (el.addEventListener) {
                el.addEventListener(evt, proxy, false);
            }
        },
        undelegate: function(el, evt, sel, handler) {
            if (!handler) {
                var listeners = el.listeners[evt];
                listeners.forEach(function(proxy) {
                    el.removeEventListener(evt, proxy, false);
                });
            } else {
                var proxyids = handler.proxy[evt];
                if (proxyids.length) {
                    proxyids.forEach(function(proxyid) {
                        if (el.removeEventListener) {
                            el.removeEventListener(evt, this.proxies[this.proxyid], false);
                        }
                    });
                }
            }
        }
    };

    var config = {
        tap: true,
        doubleTap: true,
        tapMaxDistance: 10,
        hold: true,
        tapTime: 200,
        holdTime: 650,
        maxDoubleTapInterval: 300,
        swipe: true,
        swipeTime: 300,
        swipeMinDistance: 18,
        swipeFactor: 5,
        drag: true,
        pinch: true,
        minScaleRate: 0,
        minRotationAngle: 15
    };

    var smrEventList = {
        TOUCH_START: 'touchstart',
        TOUCH_MOVE: 'touchmove',
        TOUCH_END: 'touchend',
        TOUCH_CANCEL: 'touchcancel',
        MOUSE_DOWN: 'mousedown',
        MOUSE_MOVE: 'mousemove',
        MOUSE_UP: 'mouseup',
        CLICK: 'click',
        PINCH_START: 'pinchstart',
        PINCH_END: 'pinchend',
        PINCH: 'pinch',
        PINCH_IN: 'pinchin',
        PINCH_OUT: 'pinchout',
        ROTATION_LEFT: 'rotateleft',
        ROTATION_RIGHT: 'rotateright',
        ROTATION: 'rotate',
        SWIPE_START: 'swipestart',
        SWIPING: 'swiping',
        SWIPE_END: 'swipeend',
        SWIPE_LEFT: 'swipeleft',
        SWIPE_RIGHT: 'swiperight',
        SWIPE_UP: 'swipeup',
        SWIPE_DOWN: 'swipedown',
        SWIPE: 'swipe',
        DRAG: 'drag',
        DRAGSTART: 'dragstart',
        DRAGEND: 'dragend',
        HOLD: 'hold',
        TAP: 'tap',
        DOUBLE_TAP: 'doubletap'
    };

    /** 手势识别 */
    var pos = {
        start: null,
        move: null,
        end: null
    };

    var startTime = 0;
    var fingers = 0;
    var startEvent = null;
    var moveEvent = null;
    var endEvent = null;
    var startSwiping = false;
    var startPinch = false;
    var startDrag = false;

    var __offset = {};
    var __touchStart = false;
    var __holdTimer = null;
    var __tapped = false;
    var __lastTapEndTime = null;
    var __tapTimer = null;

    var __scale_last_rate = 1;
    var __rotation_single_finger = false;
    var __rotation_single_start = [];
    var __initial_angle = 0;
    var __rotation = 0;

    var __prev_tapped_end_time = 0;
    var __prev_tapped_pos = null;

    var gestures = {
        getAngleDiff: function(currentPos) {
            var diff = parseInt(__initial_angle - utils.getAngle180(currentPos[0], currentPos[1]), 10);
            var count = 0;

            while (Math.abs(diff - __rotation) > 90 && count++ < 50) {
                if (__rotation < 0) {
                    diff -= 180;
                } else {
                    diff += 180;
                }
            }
            __rotation = parseInt(diff, 10);
            return __rotation;
        },
        pinch: function(ev) {
            var el = ev.target;
            if (config.pinch) {
                if (!__touchStart) return;
                if (utils.getFingers(ev) < 2) {
                    if (!utils.isTouchEnd(ev)) return;
                }
                var scale = utils.calScale(pos.start, pos.move);
                var rotation = this.getAngleDiff(pos.move);
                var eventObj = {
                    type: '',
                    originEvent: ev,
                    scale: scale,
                    rotation: rotation,
                    direction: (rotation > 0 ? 'right' : 'left'),
                    fingersCount: utils.getFingers(ev)
                };
                if (!startPinch) {
                    startPinch = true;
                    eventObj.fingerStatus = "start";
                    engine.trigger(el, smrEventList.PINCH_START, eventObj);
                } else if (utils.isTouchMove(ev)) {
                    eventObj.fingerStatus = "move";
                    engine.trigger(el, smrEventList.PINCH, eventObj);
                } else if (utils.isTouchEnd(ev)) {
                    eventObj.fingerStatus = "end";
                    engine.trigger(el, smrEventList.PINCH_END, eventObj);
                    utils.reset();
                }

                if (Math.abs(1 - scale) > config.minScaleRate) {
                    var scaleEv = utils.simpleClone(eventObj);

                    //手势放大, 触发pinchout事件
                    var scale_diff = 0.00000000001; //防止touchend的scale与__scale_last_rate相等，不触发事件的情况。
                    if (scale > __scale_last_rate) {
                        __scale_last_rate = scale - scale_diff;
                        engine.trigger(el, smrEventList.PINCH_OUT, scaleEv, false);
                    } //手势缩小,触发pinchin事件
                    else if (scale < __scale_last_rate) {
                        __scale_last_rate = scale + scale_diff;
                        engine.trigger(el, smrEventList.PINCH_IN, scaleEv, false);
                    }

                    if (utils.isTouchEnd(ev)) {
                        __scale_last_rate = 1;
                    }
                }

                if (Math.abs(rotation) > config.minRotationAngle) {
                    var rotationEv = utils.simpleClone(eventObj),
                        eventType;

                    eventType = rotation > 0 ? smrEventList.ROTATION_RIGHT : smrEventList.ROTATION_LEFT;
                    engine.trigger(el, eventType, rotationEv, false);
                    engine.trigger(el, smrEventList.ROTATION, eventObj);
                }

            }
        },
        rotateSingleFinger: function(ev) {
            var el = ev.target;
            if (__rotation_single_finger && utils.getFingers(ev) < 2) {
                if (!pos.move) return;
                if (__rotation_single_start.length < 2) {
                    var docOff = utils.getXYByElement(el);

                    __rotation_single_start = [{
                        x: docOff.left + el.offsetWidth / 2,
                        y: docOff.top + el.offsetHeight / 2
                    },
                        pos.move[0]
                    ];
                    __initial_angle = parseInt(utils.getAngle180(__rotation_single_start[0], __rotation_single_start[1]), 10);
                }
                var move = [__rotation_single_start[0], pos.move[0]];
                var rotation = this.getAngleDiff(move);
                var eventObj = {
                    type: '',
                    originEvent: ev,
                    rotation: rotation,
                    direction: (rotation > 0 ? 'right' : 'left'),
                    fingersCount: utils.getFingers(ev)
                };
                if (utils.isTouchMove(ev)) {
                    eventObj.fingerStatus = "move";
                } else if (utils.isTouchEnd(ev) || ev.type === 'mouseout') {
                    eventObj.fingerStatus = "end";
                    engine.trigger(el, smrEventList.PINCH_END, eventObj);
                    utils.reset();
                }
                var eventType = rotation > 0 ? smrEventList.ROTATION_RIGHT : smrEventList.ROTATION_LEFT;
                engine.trigger(el, eventType, eventObj);
                engine.trigger(el, smrEventList.ROTATION, eventObj);
            }
        },
        swipe: function(ev) {
            var el = ev.target;
            if (!__touchStart || !pos.move || utils.getFingers(ev) > 1) {
                return;
            }

            var now = Date.now();
            var touchTime = now - startTime;
            var distance = utils.getDistance(pos.start[0], pos.move[0]);
            var position = {
                x: pos.move[0].x - __offset.left,
                y: pos.move[0].y - __offset.top
            };
            var angle = utils.getAngle(pos.start[0], pos.move[0]);
            var direction = utils.getDirectionFromAngle(angle);
            var touchSecond = touchTime / 1000;
            var factor = ((10 - config.swipeFactor) * 10 * touchSecond * touchSecond);
            var eventObj = {
                type: smrEventList.SWIPE,
                originEvent: ev,
                position: position,
                direction: direction,
                distance: distance,
                distanceX: pos.move[0].x - pos.start[0].x,
                distanceY: pos.move[0].y - pos.start[0].y,
                x: pos.move[0].x - pos.start[0].x,
                y: pos.move[0].y - pos.start[0].y,
                angle: angle,
                duration: touchTime,
                fingersCount: utils.getFingers(ev),
                factor: factor
            };
            if (config.swipe) {
                var swipeTo = function() {
                    var elt = smrEventList;
                    switch (direction) {
                        case 'up':
                            engine.trigger(el, elt.SWIPE_UP, eventObj);
                            break;
                        case 'down':
                            engine.trigger(el, elt.SWIPE_DOWN, eventObj);
                            break;
                        case 'left':
                            engine.trigger(el, elt.SWIPE_LEFT, eventObj);
                            break;
                        case 'right':
                            engine.trigger(el, elt.SWIPE_RIGHT, eventObj);
                            break;
                    }
                };

                if (!startSwiping) {
                    eventObj.fingerStatus = eventObj.swipe = 'start';
                    startSwiping = true;
                    engine.trigger(el, smrEventList.SWIPE_START, eventObj);
                } else if (utils.isTouchMove(ev)) {
                    eventObj.fingerStatus = eventObj.swipe = 'move';
                    engine.trigger(el, smrEventList.SWIPING, eventObj);

                    if (touchTime > config.swipeTime && touchTime < config.swipeTime + 50 && distance > config.swipeMinDistance) {
                        swipeTo();
                        engine.trigger(el, smrEventList.SWIPE, eventObj, false);
                    }
                } else if (utils.isTouchEnd(ev) || ev.type === 'mouseout') {
                    eventObj.fingerStatus = eventObj.swipe = 'end';
                    engine.trigger(el, smrEventList.SWIPE_END, eventObj);

                    if (config.swipeTime > touchTime && distance > config.swipeMinDistance) {
                        swipeTo();
                        engine.trigger(el, smrEventList.SWIPE, eventObj, false);
                    }
                }
            }

            if (config.drag) {
                if (!startDrag) {
                    eventObj.fingerStatus = eventObj.swipe = 'start';
                    startDrag = true;
                    engine.trigger(el, smrEventList.DRAGSTART, eventObj);
                } else if (utils.isTouchMove(ev)) {
                    eventObj.fingerStatus = eventObj.swipe = 'move';
                    engine.trigger(el, smrEventList.DRAG, eventObj);
                } else if (utils.isTouchEnd(ev)) {
                    eventObj.fingerStatus = eventObj.swipe = 'end';
                    engine.trigger(el, smrEventList.DRAGEND, eventObj);
                }

            }
        },
        tap: function(ev) {
            var el = ev.target;
            if (config.tap) {
                var now = Date.now();
                var touchTime = now - startTime;
                var distance = utils.getDistance(pos.start[0], pos.move ? pos.move[0] : pos.start[0]);

                clearTimeout(__holdTimer);
                var isDoubleTap = (function() {
                    if (__prev_tapped_pos && config.doubleTap && (startTime - __prev_tapped_end_time) < config.maxDoubleTapInterval) {
                        var doubleDis = utils.getDistance(__prev_tapped_pos, pos.start[0]);
                        if (doubleDis < 16) return true;
                    }
                    return false;
                })();

                if (isDoubleTap) {
                    clearTimeout(__tapTimer);
                    engine.trigger(el, smrEventList.DOUBLE_TAP, {
                        type: smrEventList.DOUBLE_TAP,
                        originEvent: ev,
                        position: pos.start[0]
                    });
                    return;
                }

                if (config.tapMaxDistance < distance) return;

                if (config.holdTime > touchTime && utils.getFingers(ev) <= 1) {
                    __tapped = true;
                    __prev_tapped_end_time = now;
                    __prev_tapped_pos = pos.start[0];
                    __tapTimer = setTimeout(function() {
                            engine.trigger(el, smrEventList.TAP, {
                                type: smrEventList.TAP,
                                originEvent: ev,
                                fingersCount: utils.getFingers(ev),
                                position: __prev_tapped_pos
                            });
                        },
                        config.tapTime);
                }
            }
        },
        hold: function(ev) {
            var el = ev.target;
            if (config.hold) {
                clearTimeout(__holdTimer);

                __holdTimer = setTimeout(function() {
                        if (!pos.start) return;
                        var distance = utils.getDistance(pos.start[0], pos.move ? pos.move[0] : pos.start[0]);
                        if (config.tapMaxDistance < distance) return;

                        if (!__tapped) {
                            engine.trigger(el, "hold", {
                                type: 'hold',
                                originEvent: ev,
                                fingersCount: utils.getFingers(ev),
                                position: pos.start[0]
                            });
                        }
                    },
                    config.holdTime);
            }
        }
    };

    var handlerOriginEvent = function(ev) {

        var el = ev.target;
        switch (ev.type) {
            case 'touchstart':
            case 'mousedown':
                __rotation_single_start = [];
                __touchStart = true;
                if (!pos.start || pos.start.length < 2) {
                    pos.start = utils.getPosOfEvent(ev);
                }
                if (utils.getFingers(ev) >= 2) {
                    __initial_angle = parseInt(utils.getAngle180(pos.start[0], pos.start[1]), 10);
                }

                startTime = Date.now();
                startEvent = ev;
                __offset = {};

                var box = el.getBoundingClientRect();
                var docEl = document.documentElement;
                __offset = {
                    top: box.top + (window.pageYOffset || docEl.scrollTop) - (docEl.clientTop || 0),
                    left: box.left + (window.pageXOffset || docEl.scrollLeft) - (docEl.clientLeft || 0)
                };

                gestures.hold(ev);
                break;
            case 'touchmove':
            case 'mousemove':
                if (!__touchStart || !pos.start) return;
                pos.move = utils.getPosOfEvent(ev);
                if (utils.getFingers(ev) >= 2) {
                    gestures.pinch(ev);
                } else if (__rotation_single_finger) {
                    gestures.rotateSingleFinger(ev);
                } else {
                    gestures.swipe(ev);
                }
                break;
            case 'touchend':
            case 'touchcancel':
            case 'mouseup':
            case 'mouseout':
                if (!__touchStart) return;
                endEvent = ev;

                if (startPinch) {
                    gestures.pinch(ev);
                } else if (__rotation_single_finger) {
                    gestures.rotateSingleFinger(ev);
                } else if (startSwiping) {
                    gestures.swipe(ev);
                } else {
                    gestures.tap(ev);
                }

                utils.reset();
                __initial_angle = 0;
                __rotation = 0;
                if (ev.touches && ev.touches.length === 1) {
                    __touchStart = true;
                    __rotation_single_finger = true;
                }
                break;
        }
    };

    var _on = function() {

        var evts, handler, evtMap, sel, args = arguments;
        if (args.length < 2 || args > 4) {
            return console.error("unexpected arguments!");
        }
        var els = utils.getType(args[0]) === 'string' ? document.querySelectorAll(args[0]) : args[0];
        els = els.length ? Array.prototype.slice.call(els) : [els];
        //事件绑定
        if (args.length === 3 && utils.getType(args[1]) === 'string') {
            evts = args[1].split(" ");
            handler = args[2];
            evts.forEach(function(evt) {
                if (!utils.hasTouch) {
                    evt = utils.getPCevts(evt);
                }
                els.forEach(function(el) {
                    engine.bind(el, evt, handler);
                });
            });
            return;
        }

        function evtMapDelegate(evt) {
            if (!utils.hasTouch) {
                evt = utils.getPCevts(evt);
            }
            els.forEach(function(el) {
                engine.delegate(el, evt, sel, evtMap[evt]);
            });
        }
        //mapEvent delegate
        if (args.length === 3 && utils.getType(args[1]) === 'object') {
            evtMap = args[1];
            sel = args[2];
            for (var evt1 in evtMap) {
                evtMapDelegate(evt1);
            }
            return;
        }

        function evtMapBind(evt) {
            if (!utils.hasTouch) {
                evt = utils.getPCevts(evt);
            }
            els.forEach(function(el) {
                engine.bind(el, evt, evtMap[evt]);
            });
        }

        //mapEvent bind
        if (args.length === 2 && utils.getType(args[1]) === 'object') {
            evtMap = args[1];
            for (var evt2 in evtMap) {
                evtMapBind(evt2);
            }
            return;
        }

        //兼容factor config
        if (args.length === 4 && utils.getType(args[2]) === "object") {
            evts = args[1].split(" ");
            handler = args[3];
            evts.forEach(function(evt) {
                if (!utils.hasTouch) {
                    evt = utils.getPCevts(evt);
                }
                els.forEach(function(el) {
                    engine.bind(el, evt, handler);
                });
            });
            return;
        }

        //事件代理
        if (args.length === 4) {
            var el = els[0];
            evts = args[1].split(" ");
            sel = args[2];
            handler = args[3];
            evts.forEach(function(evt) {
                if (!utils.hasTouch) {
                    evt = utils.getPCevts(evt);
                }
                engine.delegate(el, evt, sel, handler);
            });
            return;
        }
    };

    var _off = function() {
        var evts, handler;
        var args = arguments;
        if (args.length < 1 || args.length > 4) {
            return console.error("unexpected arguments!");
        }
        var els = utils.getType(args[0]) === 'string' ? document.querySelectorAll(args[0]) : args[0];
        els = els.length ? Array.prototype.slice.call(els) : [els];

        if (args.length === 1 || args.length === 2) {
            els.forEach(function(el) {
                evts = args[1] ? args[1].split(" ") : Object.keys(el.listeners);
                if (evts.length) {
                    evts.forEach(function(evt) {
                        if (!utils.hasTouch) {
                            evt = utils.getPCevts(evt);
                        }
                        engine.unbind(el, evt);
                        engine.undelegate(el, evt);
                    });
                }
            });
            return;
        }

        if (args.length === 3 && utils.getType(args[2]) === 'function') {
            handler = args[2];
            els.forEach(function(el) {
                evts = args[1].split(" ");
                evts.forEach(function(evt) {
                    if (!utils.hasTouch) {
                        evt = utils.getPCevts(evt);
                    }
                    engine.unbind(el, evt, handler);
                });
            });
            return;
        }

        if (args.length === 3 && utils.getType(args[2]) === 'string') {
            var sel = args[2];
            els.forEach(function(el) {
                evts = args[1].split(" ");
                evts.forEach(function(evt) {
                    if (!utils.hasTouch) {
                        evt = utils.getPCevts(evt);
                    }
                    engine.undelegate(el, evt, sel);
                });
            });
            return;
        }

        if (args.length === 4) {
            handler = args[3];
            els.forEach(function(el) {
                evts = args[1].split(" ");
                evts.forEach(function(evt) {
                    if (!utils.hasTouch) {
                        evt = utils.getPCevts(evt);
                    }
                    engine.undelegate(el, evt, sel, handler);
                });
            });
            return;
        }
    };

    var _dispatch = function(el, evt, detail) {
        var args = arguments;
        if (!utils.hasTouch) {
            evt = utils.getPCevts(evt);
        }
        var els = utils.getType(args[0]) === 'string' ? document.querySelectorAll(args[0]) : args[0];
        els = els.length ? Array.prototype.call(els) : [els];

        els.forEach(function(el) {
            engine.trigger(el, evt, detail);
        });
    };

    //init gesture
    function init() {

        var mouseEvents = 'mouseup mousedown mousemove mouseout',
            touchEvents = 'touchstart touchmove touchend touchcancel';
        var bindingEvents = utils.hasTouch ? touchEvents : mouseEvents;

        bindingEvents.split(" ").forEach(function(evt) {
            document.addEventListener(evt, handlerOriginEvent, false);
        });
    }

    init();

    var exports = {};

    exports.on = exports.bind = exports.live = _on;
    exports.off = exports.unbind = exports.die = _off;
    exports.config = config;
    exports.trigger = _dispatch;

    return exports;
}));
/********************************************* */

;(function (factory) {
    /* CommonJS module. */
    if (typeof module === "object" && typeof module.exports === "object") {
        module.exports = factory(window);
        /* AMD module. */
    } else if (typeof define === "function" && define.amd) {
        define(factory(window));
        /* Browser globals. */
    } else {
        factory(window);
    }
}(function(global, undefined) {
    "use strict";

    var veCropProtytype = veCrop.prototype;
    //默认参数
    
    var defaults = {
        img: '',	//图片对象
        frame: '',  //拖动框
        cropFrame: '', //裁剪框
        frameBorderWidth: 0, //裁剪框边框
        Touch: window.touch	//手势库
    };

    /*****************************************************************************************************************
     * 工具函数
     ****************************************************************************************************************/
    /**
     * 简单的数组合并
     */
    function extend(source, target) {
        for(var key in source) {
            if(source.hasOwnProperty(key))
                target[key] = source[key];
        }
        return target;
    }

    /**
     * devicePixelRatio设备像素比 webkitBackingStorePixelRatio Canvas缓冲区的像素比
     * 作用就是让Canvas中每个像素和手机屏幕的物理像素1：1对应，在Canvas中画线或写字可以更清晰
     */
    function pixelRatio(ctx) {
        // ctx.webkitBackingStorePixelRatio|| 
        var backingstore = 1;
        return (window.devicePixelRatio || 1) / backingstore;
    }

    /**
     * 角度换算为弧度
     * @param deg
     * @returns {number}
     */
    function radian(deg) {
        return deg * Math.PI / 180;
    }
    function sin(digit, deg) {
        return digit * Math.sin(radian(deg));
    }
    function cos(digit, deg) {
        return digit * Math.cos(radian(deg));
    }

    /**
     * 0--90°与180°--270°之间的宽高计算
     */
    function caculate1(width, height, deg) {
        var canvasWidth = (cos(width, deg) + sin(height, deg));
        var canvasHeight = (sin(width, deg) + cos(height, deg));
        return [canvasWidth, canvasHeight];
    }

    /**
     * 90°--180°与270°--360°之间的宽高计算
     */
    function caculate2(width, height, deg) {
        var canvasWidth = (sin(width, deg) + cos(height, deg));
        var canvasHeight = (cos(width, deg) + sin(height, deg));
        return [canvasWidth, canvasHeight];
    }

    /**
     * 旋转后canvas宽高，以及偏移设置
     * @param deg 角度
     * @param width 图片实际宽度
     * @param height 图片实际高度
     * @param pr 设备像素比与Canvas缓冲区的像素比的比率
     * @returns {*[]}
     */
    function rotateCanvas(deg, width, height, pr) {
        var caculate, x=0, y=0;
        if(deg <= 90) {
            caculate = caculate1(width, height, deg);
            x = sin(height, deg);
        }else if(deg <= 180) {
            deg = deg - 90;
            caculate = caculate2(width, height, deg);
            x = caculate[0];
            y = sin(height, deg);
        }else if(deg <= 270) {
            deg = deg - 180;
            caculate = caculate1(width, height, deg);
            x = cos(width, deg);
            y = caculate[1];
        }else if(deg <= 360) {
            deg = deg - 270;
            caculate = caculate2(width, height, deg);
            y = cos(width, deg);
        }
        return [caculate[0]/pr, caculate[1]/pr, x/pr, y/pr];
    }

    /**
     * 将框内的图片裁剪出来
     * @param ctx
     * @param image
     * @param offset
     */
    function drawImage(ctx, image, offset) {
        var pr = pixelRatio(ctx), key;
        ctx.save();

        for(key in offset.image) {
            offset.image[key] = Math.floor(offset.image[key]);
        }
        for(key in offset.frame) {
            offset.frame[key] = Math.floor(offset.frame[key]);
        }

        ctx.drawImage(image[0] || image,
            offset.image.x, offset.image.y, offset.image.w, offset.image.h,
            offset.frame.x * pr, offset.frame.y * pr, offset.frame.w * pr, offset.frame.h * pr);

        ctx.restore();
    }

    /*****************************************************************************************************************
     * 对象
     ****************************************************************************************************************/
    function veCrop(opts) {
        if(!opts.img) {
            throw new Error('请传入正确的图片');
        }
        this.opts = extend(opts, defaults); //默认参数与传入参数合并
        this.init();
        this.initTouch();
    }

    /**
     * 更新图片尺寸
     * @param width
     * @param height
     */
    veCropProtytype.setSize = function(width, height) {
        //var id = this.opts.img.getAttribute('id');
        //this.opts.img = document.getElementById(id);
        width && this.opts.img.setAttribute('data-width', width);//实际宽度
        height && this.opts.img.setAttribute('data-height', height);//实际高度
    };

    /**
     * 初始化参数
     */
    veCropProtytype.init = function() {
        this.param = {
            offsetX : 0,//X轴偏移
            offsetY : 0,//Y轴偏移
            scale : 1,//缩放倍数
            deg : 0//角度
        };
        this.opts.img.style.webkitTransform = '';//清除图片属性
    };

    /**
     * 设置param参数
     */
    veCropProtytype.getParam = function() {
        return this.param;
    };

    /**
     * 裁剪生成
     */
    veCropProtytype.generate = function(fn) {
        //this.updateImage();
        var image = this.opts.img, _this = this;
        var cropFrame = this.opts.cropFrame;
        var frameOffset = cropFrame.getBoundingClientRect();
        var src = this.filterImage(image);//旋转平移缩放后的图片
        console.log("srcsrcsrcsrcsrc",src);
        var img = new Image();
        var originWidth = image.getAttribute('data-width') || image.width || image.naturalWidth,//图片原始的宽高
            originHeight = image.getAttribute('data-height') || image.height || image.naturalHeight;
        img.onload = function() {
            _this.setSize(this.width, this.height);//将旋转后的图片尺寸临时存放在全局img中

            var canvas = document.createElement('canvas');
            canvas.width = frameOffset.width;//裁剪框的宽高
            canvas.height = frameOffset.height;
            var ctx = canvas.getContext('2d');

            ctx.fillStyle = '#FFF';//绘制背景色
            ctx.fillRect(0,0,canvas.width,canvas.height);

            var params = _this.intersect(cropFrame);//计算裁剪框与操作后的图片位置关系

            drawImage(ctx, this, params);//在旋转放大平移后的图片中选中位置裁剪

            var base64 = canvas.toDataURL('image/jpeg');

            _this.setSize(originWidth, originHeight);
            fn && fn.call(this, base64);
        };
        img.src = src;
    };

    /**
     * 操作图片 压缩/旋转
     * @param image 图片对象
     * @param coor 操作参数,宽高角度
     * @returns {string}
     */
    veCropProtytype.filterImage = function(image, coor) {
        coor = coor || {};
        var canvas = document.createElement('canvas'),
            width = coor['width'] || image.getAttribute('data-width') || image.clientWidth || image.width || image.naturalWidth,//图片真实宽度
            height = coor['height'] || image.getAttribute('data-height') || image.clientHeight || image.height || image.naturalHeight,
            deg = coor['deg'] || this.param.deg;//图片真实高度
        var pr = pixelRatio(canvas.getContext('2d'));
        console.log(pr);
        console.log('width= ', width);
        console.log('height = ', height);
        var caculate;
        //将负值转换成正值
        if(deg < 0) {
            deg = deg + 360;
        }
        deg = deg % 360;
        console.log('deg = ', deg);
        if(deg) {
            caculate = rotateCanvas(deg, width, height, pr);
            canvas.width = caculate[0];
            canvas.height = caculate[1];
        }else {
            canvas.width = width / pr;//回复为原先的大小
            canvas.height = height / pr;
        }
        console.log(canvas);
        console.log('caculate = ', caculate);
        var ctx = canvas.getContext('2d');
        ctx.fillStyle = '#FFF';//绘制背景色
        ctx.fillRect(0, 0, canvas.width, canvas.height);

        if(deg) {
            ctx.translate(caculate[2], caculate[3]);
            ctx.rotate(radian(deg));
            ctx.drawImage(image, 0, 0);
        }else {
            ctx.drawImage(image, 0, 0, width, height);
        }
        console.log(canvas);
        return canvas.toDataURL('image/jpeg', 0.5);//压缩质量为.5
    };

    /**
     * 操作图片旋转缩放拖动
     * @param offx
     * @param offy
     * @param scale
     * @param deg
     */
    veCropProtytype.formatTransform = function(offx, offy, scale, deg) {
        var translate = 'translate3d(' + (offx + 'px,') + (offy + 'px,') + '0)';
        var scaleStr = 'scale3d('+scale+','+scale+','+scale+')';
        var rotate = 'rotate('+deg+'deg)';
        this.opts.img.style.webkitTransform =  translate + ' ' + scaleStr + ' ' + rotate;
    };

    /**
     * 操作图片放大缩小
     */
    veCropProtytype.shrinkImg = function() {
        this.param.scale = this.param.scale - 0.1;
        this.formatTransform(this.param.offsetX, this.param.offsetY, this.param.scale, this.param.deg);
    }
    veCropProtytype.magnifyImg = function() {
        console.log(this.param.scale);
        this.param.scale = this.param.scale + 0.1;
        this.formatTransform(this.param.offsetX, this.param.offsetY, this.param.scale, this.param.deg);
    }
    veCropProtytype.leftImg = function() {
        this.param.offsetX -= Math.ceil(100 * this.param.scale);
        this.formatTransform(this.param.offsetX, this.param.offsetY, this.param.scale, this.param.deg);
    }
    veCropProtytype.rightImg = function() {
        this.param.offsetX += Math.ceil(100 * this.param.scale);
        this.formatTransform(this.param.offsetX, this.param.offsetY, this.param.scale, this.param.deg);
    }
    veCropProtytype.topImg = function() {
        this.param.offsetY -= Math.ceil(100 * this.param.scale);
        this.formatTransform(this.param.offsetX, this.param.offsetY, this.param.scale, this.param.deg);
    }
    veCropProtytype.bottomImg = function() {
        this.param.offsetY += Math.ceil(100 * this.param.scale);
        this.formatTransform(this.param.offsetX, this.param.offsetY, this.param.scale, this.param.deg);
    }

    /**
     * 初始化手势事件 目前是touch.js，可以做更多的适配
     */
    veCropProtytype.initTouch = function() {
        var currScale, _this = this,
            Touch = this.opts.Touch,
            frame = this.opts.frame;

        // Touch.on(frame, 'rotate', function (ev) {
        //     var totalAngle = _this.param.deg + ev.rotation;
        //     if(ev.fingerStatus === 'end'){
        //         _this.param.deg = _this.param.deg + ev.rotation;
        //     }
        //     _this.formatTransform(_this.param.offsetX, _this.param.offsetY, _this.param.scale, totalAngle);
        // });

        // Touch.on(frame, 'touchstart', function (ev) {
        //     ev.preventDefault();
        // });

        // Touch.on(frame, 'drag', function(ev) {
        //     var currOffx = _this.param.offsetX + ev.x;
        //     var currOffy = _this.param.offsetY + ev.y;
        //     _this.formatTransform(currOffx, currOffy, _this.param.scale, _this.param.deg);
        // });

        // Touch.on(frame, 'dragend', function(ev) {
        //     _this.param.offsetX += ev.x;
        //     _this.param.offsetY += ev.y;
        // });

        // Touch.on(frame, 'pinch', function(ev) {
        //     if(typeof ev.scale != 'undefined') {
        //         currScale = ev.scale - 1 + _this.param.scale;
        //         _this.formatTransform(_this.param.offsetX, _this.param.offsetY, currScale, _this.param.deg);
        //     }
        // });

        // Touch.on(frame, 'pinchend', function() {
        //     _this.param.scale = currScale;
        // });
    };

    /**
     * 计算出图片img在frame裁剪框中的可见部分相对于img和frame的坐标及尺寸
     * @param cropFrame 裁剪框
     * @returns {{frame: {x: number, y: number, w: number, h: number}, image: {x: number, y: number, w: number, h: number}}}
     */
    veCropProtytype.intersect = function(cropFrame) {
        var imgX = 0, imgY = 0, imgW = 0, imgH = 0;
        var frmX = 0, frmY = 0;
        var imgOffset, frmOffset;
        var left, right, top, bottom;
        var img = this.opts.img,
            frameBorderWidth = this.opts.frameBorderWidth,
            frameBorderWidth2X = frameBorderWidth * 2;

        imgOffset = img.getBoundingClientRect();//图片的偏移对象
        frmOffset = cropFrame.getBoundingClientRect();//裁剪框的偏移对象
        left = imgOffset.left - frmOffset.left - frameBorderWidth;//图片到边框左边的距离 去除边框宽度
        right = left + imgOffset.width;//图片宽度需要减去边框的宽度
        top = imgOffset.top - frmOffset.top - frameBorderWidth;//图片到边框上边的距离
        bottom = top + imgOffset.height;

        //图片在画框内
        if(!(right <= 0 || left >= frmOffset.width || bottom <= 0 || top >= frmOffset.height)) {
            if(left < 0) {
                imgX = -left;
                frmX = 0;
                imgW = (right < frmOffset.width) ? right : frmOffset.width;
            } else {
                imgX = 0;
                frmX = left;
                imgW = (right < frmOffset.width ? right : frmOffset.width) - left;
            }

            if(top < 0) {
                imgY = -top;
                frmY = 0;
                imgH = (bottom < frmOffset.height) ? bottom : frmOffset.height;
            } else {
                imgY = 0;
                frmY = top;
                imgH = ((bottom < frmOffset.height) ? bottom : frmOffset.height) - top;

            }
        }

        var ratio = img.getAttribute('data-width') / imgOffset.width;//图片真实宽度 与 图片CSS宽度
        //图片的实际高度不能低于计算后的高度 否则iphone 5S中就不显示
        var imageHeight = imgH * ratio;
        if(+img.getAttribute('data-height') < imageHeight) {
            imageHeight = img.getAttribute('data-height');
        }

        return {
            frame: {x: frmX, y: frmY, w: (imgW + frameBorderWidth2X), h: (imgH + frameBorderWidth2X)},//此处画框是650，而画布是654
            image: {x: imgX * ratio, y: imgY * ratio, w: imgW * ratio, h: imageHeight}
        };
    };

    global.veCrop = veCrop;
    return veCrop;
}));


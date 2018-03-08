/**
 * @author v_duantao
 * @file 获取字典信息列表
 * @date 17/10/22 下午2:03
 */
import Fetch from 'Fetch/Fetch'
window.LIST = {};

window.LIST.cityList = [];
function getCityList(value) {
    if (value >= 33) {
        return false;
    }
    let url = `public/region/queryByPid/${value}`;
    Fetch.get(url).then(res => {
        let data = res.data;
        if (data.length !== 0) {
            if (value === 1) {
                data.map(item => {
                    let li = {
                        value: item.regionId,
                        label: item.regionName,
                        children: []
                    };
                    getCityList(item.regionId);
                    window.LIST.cityList.push(li);
                });
            } else {
                data.map(item => {
                    let chilList = {
                        value: item.regionId,
                        label: item.regionName,
                    };
                    window.LIST.cityList[value - 2].children.push(chilList);
                });
            }
        }
    })
}
window.LIST.professionalTypeList=[];
let typeList1 = [];
function getProfessionalTypeList(value) {
    if (value >= 7) {
        window.LIST.professionalTypeList = typeList1;
        return false;
    }
    let url = `public/professionalType/queryByPid/${value}`;
    Fetch.get(url).then(res => {
        let data = res.data;
        if (data.length !== 0) {
            if (value === 0) {
                data.map(item => {
                    let li = {
                        value: item.professionalTypeId,
                        label: item.professionalTypeName,
                        children: []
                    };
                    getProfessionalTypeList(item.professionalTypeId);
                    typeList1.push(li);
                });
            } else {
                data.map(item => {
                    let chilList = {
                        value: item.professionalTypeId,
                        label: item.professionalTypeName,
                    };
                    typeList1[value - 1].children.push(chilList);
                });
            }
        }
    })
}

window.LIST.eduList=[]
function getDictionaryList() {
// 获取城市列表
    getCityList(1);

// 获取大匠分类的列表
    getProfessionalTypeList(0);

// 获取学历列表
    Fetch.get('public/dict/queryDegreeCode').then(res => {
        let data = res.data;
        let eduList = [];
        data.map(item => {
            let li = {
                value: item.itemCode,
                label: item.itemValue
            };
            eduList.push(li);
        });
        window.LIST.eduList = eduList;
    });
    window.LIST.sexList=[];
// 获取性别
    Fetch.get('public/dict/querySexCode').then(res => {
        let data = res.data;
        let sexList = [];
        data.map(item => {
            let li = {
                value: item.itemCode,
                label: item.itemValue
            };
            sexList.push(li);
        });
        window.LIST.sexList = data;
    });
    window.LIST.patentTypeLsit=[];
// 获取专利类型
    Fetch.get('public/dict/queryPatentType').then(res => {
        let data = res.data;
        let sexList = [];
        data.map(item => {
            let li = {
                value: item.itemCode,
                label: item.itemValue
            };
            sexList.push(li);
        });
        window.LIST.patentTypeLsit = sexList;
    });
    window.LIST.productStyleList=[];
// 获取产品类型
    Fetch.get('public/dict/queryProductStyle').then(res => {
        let data = res.data;
        let sexList = [];
        data.map(item => {
            let li = {
                value: item.itemCode,
                label: item.itemValue
            };
            sexList.push(li);
        });
        window.LIST.productStyleList = sexList;
    });
    window.LIST.productStyleCodeList=[];
// 获取产品发布类型
    Fetch.get('public/dict/queryProductTypeCode').then(res => {
        let data = res.data;
        let sexList = [];
        data.map(item => {
            let li = {
                value: item.itemCode,
                label: item.itemValue
            };
            sexList.push(li);
        });
        window.LIST.productStyleCodeList = sexList;
    });
    window.LIST.photoTypeList=[];
// 获取图片类型
    Fetch.get('public/dict/queryPhotoType').then(res => {
        let data = res.data;
        let sexList = [];
        data.map(item => {
            let li = {
                value: item.itemCode,
                label: item.itemValue
            };
            sexList.push(li);
        });
        window.LIST.photoTypeList = sexList;
    });
    window.LIST.productDetailTypeList=[];
// 获取产品详细类型
    Fetch.get('public/dict/queryProductDetailTypeCode').then(res => {
        let data = res.data;
        let sexList = [];
        data.map(item => {
            let li = {
                value: item.itemCode,
                label: item.itemValue
            };
            sexList.push(li);
        });
        window.LIST.productDetailTypeList = sexList;
    });
}

export default getDictionaryList;
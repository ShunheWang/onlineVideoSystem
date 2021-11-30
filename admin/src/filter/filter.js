let optionKey = (object, key) => {
    if (!object || !key) {
        return "";
    } else {
        let result = "";
        for (let enums in object) {
            console.log(object[enums]["key"]);
            if (key === object[enums]["key"]) {
                result = object[enums]["value"];
            }
        }
        return result;
    }
};

let optionKV = (object, key) => {
    if (!object || !key) {
        return "";
    } else {
        let result = "";
        for (let enums in object) {
            // console.log(object[enums]["key"]);
            if (key === object[enums]["key"]) {
                result = object[enums]["value"];
            }
        }
        return result;
    }
};

/**
 * 数组过滤器 例如：{{CHARGE | optionKVArray(section.charge)}}
 * @param list 例如：[{key:"C", value:"收费"},{key:"F", value:"免费"}]
 * @param key 例如：C
 * @returns {string} 例如：收费
 */
 let optionKVArray = (list, key) =>  {
    if (!list || !key) {
        return "";
    } else {
        let result = "";
        for (let i = 0; i < list.length; i++) {
            if (key === list[i]["key"]) {
                result = list[i]["value"];
            }
        }
        return result;
    }
};

let formatSecond = (value) => {
    value = value || 0;
    let second = parseInt(value, 10); // 秒
    let minute = 0; // 分
    let hour = 0; // 小时
    if (second > 60) {
        // 当>60秒时, 才需要做转换;
        minute = Math.floor(second / 60);
        second = Math.floor(second % 60);
        if (minute > 60) {
            // 当>60分时, 才需要做转换;
            hour = Math.floor(minute / 60);
            minute = Math.floor(minute % 60);
        }
        
    } else {
        // <60秒不需要处理, 直接显示
    }
    let result = "" + PrefixInteger(second, 2) + "";
    if (minute > 0) {
        // 拼接上分钟
        result = "" + PrefixInteger(minute, 2) + ":" + result;
        if (hour > 0) {
            // 拼接上小时
            result = "" + PrefixInteger(hour, 2) + ":" + result;
        }
    }
    return result;
};

/**
 * 格式化指定长度, 前面多余位数补0
 */
function PrefixInteger(num, length) {
    return (Array(length).join('0') + num).slice(-length);
}

export default {
    optionKV,
    formatSecond
}
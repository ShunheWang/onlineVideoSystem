SESSION_KEY_COURSE = "SESSION_KEY_COURSE" // 课程管理 -> 大章页面, 保存课程信息
SESSION_KEY_CHAPTER = "SESSION_KEY_CHAPTER" // 大章管理 -> 小节页面, 保存大章信息

SessionStorage = {
    get: function (key) {
        let v = sessionStorage.getItem(key);
        if (v && typeof(v) !== "undefined" && v !== "undefined") {
            return JSON.parse(v);
        }
    },
    set: function (key, data) {
        sessionStorage.setItem(key, JSON.stringify(data));
    },
    remove: function (key) {
        sessionStorage.removeItem(key);
    },
    clearAll: function () {
        sessionStorage.clear();
    }
};
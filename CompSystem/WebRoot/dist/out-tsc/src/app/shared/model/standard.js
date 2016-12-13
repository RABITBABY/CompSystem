export var Standard = (function () {
    function Standard() {
    }
    Standard.prototype.StandardId = function (standardId) {
        this.standardId = standardId;
        return this;
    };
    Standard.prototype.Level = function (level) {
        this.level = level;
        return this;
    };
    Standard.prototype.Prize = function (prize) {
        this.prize = prize;
        return this;
    };
    Standard.prototype.Student = function (student) {
        this.student = student;
        return this;
    };
    Standard.prototype.Teacher = function (teacher) {
        this.teacher = teacher;
        return this;
    };
    return Standard;
}());
//# sourceMappingURL=../../../../../../src/app/shared/model/standard.js.map
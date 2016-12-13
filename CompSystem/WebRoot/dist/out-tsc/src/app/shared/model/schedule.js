export var Schedule = (function () {
    function Schedule() {
    }
    Schedule.prototype.ScheduleId = function (scheduleId) {
        this.scheduleId = scheduleId;
        return this;
    };
    Schedule.prototype.Competition = function (competition) {
        this.competition = competition;
        return this;
    };
    Schedule.prototype.Teacher = function (teacher) {
        this.teacher = teacher;
        return this;
    };
    Schedule.prototype.Content = function (content) {
        this.content = content;
        return this;
    };
    Schedule.prototype.Position = function (position) {
        this.position = position;
        return this;
    };
    Schedule.prototype.Date = function (date) {
        this.date = date;
        return this;
    };
    Schedule.prototype.Hour = function (hour) {
        this.hour = hour;
        return this;
    };
    return Schedule;
}());
//# sourceMappingURL=../../../../../../src/app/shared/model/schedule.js.map
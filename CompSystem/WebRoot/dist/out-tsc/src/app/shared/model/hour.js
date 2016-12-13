export var Hour = (function () {
    function Hour() {
    }
    Hour.prototype.HoursId = function (hoursId) {
        this.hoursId = hoursId;
        return this;
    };
    Hour.prototype.Competition = function (competition) {
        this.competition = competition;
        return this;
    };
    Hour.prototype.Type = function (type) {
        this.type = type;
        return this;
    };
    Hour.prototype.Hour = function (hours) {
        this.hours = hours;
        return this;
    };
    Hour.prototype.Remarks = function (remarks) {
        this.remarks = remarks;
        return this;
    };
    return Hour;
}());
//# sourceMappingURL=../../../../../../src/app/shared/model/hour.js.map
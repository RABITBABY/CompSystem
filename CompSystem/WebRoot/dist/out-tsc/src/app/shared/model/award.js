export var Award = (function () {
    function Award() {
    }
    Award.prototype.AwardsId = function (awardsId) {
        this.awardsId = awardsId;
        return this;
    };
    Award.prototype.Name = function (name) {
        this.name = name;
        return this;
    };
    Award.prototype.Date = function (date) {
        this.date = date;
        return this;
    };
    Award.prototype.HUnit = function (hunit) {
        this.hunit = hunit;
        return this;
    };
    Award.prototype.Prize = function (prize) {
        this.prize = prize;
        return this;
    };
    Award.prototype.Level = function (level) {
        this.level = level;
        return this;
    };
    Award.prototype.Groups = function (groups) {
        this.groups = groups;
        return this;
    };
    Award.prototype.Competition = function (competition) {
        this.competition = competition;
        return this;
    };
    Award.prototype.IsPublish = function (isPublish) {
        this.isPublish = isPublish;
        return this;
    };
    return Award;
}());
//# sourceMappingURL=../../../../../../src/app/shared/model/award.js.map
export var Project = (function () {
    function Project() {
    }
    Project.prototype.ComId = function (comId) {
        this.comId = comId;
        return this;
    };
    Project.prototype.ComName = function (comName) {
        this.comName = comName;
        return this;
    };
    Project.prototype.Level = function (level) {
        this.level = level;
        return this;
    };
    Project.prototype.Hunit = function (hunit) {
        this.hunit = hunit;
        return this;
    };
    Project.prototype.SOrganizer = function (sOrganizer) {
        this.sOrganizer = sOrganizer;
        return this;
    };
    Project.prototype.Introduction = function (introduction) {
        this.introduction = introduction;
        return this;
    };
    Project.prototype.ApplyBeginDate = function (applyBeginDate) {
        this.applyBeginDate = applyBeginDate;
        return this;
    };
    Project.prototype.ApplyEndDate = function (applyEndDate) {
        this.applyEndDate = applyEndDate;
        return this;
    };
    Project.prototype.ComDate = function (comDate) {
        this.comDate = comDate;
        return this;
    };
    Project.prototype.Cost = function (cost) {
        this.cost = cost;
        return this;
    };
    Project.prototype.Status = function (status) {
        this.status = status;
        return this;
    };
    Project.prototype.IsPublish = function (isPublish) {
        this.isPublish = isPublish;
        return this;
    };
    Project.prototype.Groups = function (groups) {
        this.groups = groups;
        return this;
    };
    return Project;
}());
//# sourceMappingURL=../../../../../../src/app/shared/model/project.js.map
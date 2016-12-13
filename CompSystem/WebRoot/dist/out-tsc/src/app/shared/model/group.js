export var Group = (function () {
    function Group() {
    }
    Group.prototype.GroupsNo = function (groupsNo) {
        this.groupsNo = groupsNo;
        return this;
    };
    Group.prototype.GroupsName = function (groupsName) {
        this.groupsName = groupsName;
        return this;
    };
    Group.prototype.Teacher = function (teacher) {
        this.teacher = teacher;
        return this;
    };
    Group.prototype.Status = function (status) {
        this.status = status;
        return this;
    };
    Group.prototype.Project = function (project) {
        this.project = project;
        return this;
    };
    Group.prototype.GroupsDetails = function (groupsDetails) {
        this.groupsDetails = groupsDetails;
        return this;
    };
    return Group;
}());
//# sourceMappingURL=../../../../../../src/app/shared/model/group.js.map
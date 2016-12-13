export var GroupDetail = (function () {
    function GroupDetail() {
    }
    GroupDetail.prototype.Id = function (id) {
        this.id = id;
        return this;
    };
    GroupDetail.prototype.Groups = function (groups) {
        this.groups = groups;
        return this;
    };
    GroupDetail.prototype.Student = function (student) {
        this.student = student;
        return this;
    };
    return GroupDetail;
}());
//# sourceMappingURL=../../../../../../src/app/shared/model/group-detail.js.map
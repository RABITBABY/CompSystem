export var Production = (function () {
    function Production() {
    }
    Production.prototype.ProId = function (proId) {
        this.proId = proId;
        return this;
    };
    Production.prototype.ProName = function (proName) {
        this.proName = proName;
        return this;
    };
    Production.prototype.Award = function (award) {
        this.award = award;
        return this;
    };
    Production.prototype.MembersName = function (membersName) {
        this.membersName = membersName;
        return this;
    };
    Production.prototype.Introduction = function (introduction) {
        this.introduction = introduction;
        return this;
    };
    Production.prototype.Pic = function (pic) {
        this.pic = pic;
        return this;
    };
    return Production;
}());
//# sourceMappingURL=../../../../../../src/app/shared/model/production.js.map
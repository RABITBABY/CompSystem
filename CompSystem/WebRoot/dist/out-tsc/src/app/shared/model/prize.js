export var Prize = (function () {
    function Prize() {
    }
    Prize.prototype.PrizeId = function (prizeId) {
        this.prizeId = prizeId;
        return this;
    };
    Prize.prototype.PrizeName = function (prizeName) {
        this.prizeName = prizeName;
        return this;
    };
    Prize.prototype.Awards = function (awards) {
        this.awards = awards;
        return this;
    };
    return Prize;
}());
//# sourceMappingURL=../../../../../../src/app/shared/model/prize.js.map
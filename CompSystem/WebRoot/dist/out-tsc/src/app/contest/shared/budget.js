export var Budget = (function () {
    function Budget() {
    }
    Budget.prototype.BudgetID = function (budgetId) {
        this.budgetId = budgetId;
        return this;
    };
    Budget.prototype.Competition = function (competition) {
        this.competition = competition;
        return this;
    };
    Budget.prototype.Subject = function (subject) {
        this.subject = subject;
        return this;
    };
    Budget.prototype.Sum = function (sum) {
        this.sum = sum;
        return this;
    };
    Budget.prototype.Reasons = function (reasons) {
        this.reasons = reasons;
        return this;
    };
    return Budget;
}());
//# sourceMappingURL=../../../../../../src/app/contest/shared/budget.js.map
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
import { Component } from '@angular/core';
import { Schedule } from './../shared/model';
import { Budget } from './../shared/model';
import { Hour } from './../shared/model';
var ContestComponent = (function () {
    function ContestComponent() {
        this.table = {
            schedule: [
                { prop: 'tno' },
                { name: 'content' },
                { name: 'place' },
                { name: 'date' },
                { name: 'hour' }
            ],
            budget: [
                { prop: 'subject' },
                { name: 'sum' },
                { name: 'reasons' }
            ],
            hour: [
                { prop: 'type' },
                { name: 'hour' },
                { name: 'remarks' }
            ]
        };
        this.title = '申报书';
        this.declaration = {
            baseInfo: {
                title: '基本信息',
                name: '竞赛名称',
                leader: '竞赛负责人',
                unit: '所在单位(盖章)',
                type: '竞赛类别',
                phone: '联系电话',
                email: '电子邮箱',
                date: '填表日期'
            },
            competitionSituation: {
                title: '竞赛情况',
                host: '院级以上竞赛举办者',
                time: '竞赛时间',
                place: '竞赛地点',
                object: '参赛对象',
                people: '参赛人数',
                sponsor: '校外资助单位',
                intro: '竞赛简介'
            },
            implementationPlan: {
                title: '实施方案',
                instructor: '指导教师',
                instructorNo: '教职工号',
                plan: '学科竞赛实施方案',
                schedule: {
                    title: '培训工作安排',
                    content: '培训内容',
                    place: '培训地点',
                    date: '培训日期',
                    hour: '学时'
                }
            },
            goal: {
                title: '目标',
                tgoal: '能力训练目标',
                wgoal: '竞赛获奖目标'
            },
            budget: {
                title: '经费预算',
                scription: '经费预算(包括报名费、材料费、设备仪器费、交通差旅费等)',
                budget: {
                    title: '经费预算',
                    subject: '支出科目',
                    sum: '金额(元)',
                    reasons: '计算依据及理由'
                },
                hour: {
                    title: '课时预算',
                    type: '课时类别',
                    hours: '课时数(学时)',
                    remarks: '备注'
                }
            },
            opinion: {
                uopinion: '竞赛组织实施单位意见',
                tdopinion: '教学处意见'
            }
        };
        this.types = [
            { value: 'A类' },
            { value: 'B类' },
            { value: 'C类' }
        ];
        this.myOptions = [
            { id: 3, name: 'Option 3' },
            { id: 4, name: 'Option 4' },
            { id: 1, name: 'Option 1' },
            { id: 2, name: 'Option 2' }
        ];
        this.mySettings = {
            pullRight: false,
            enableSearch: true,
            checkedStyle: 'glyphicon',
            buttonClasses: 'btn btn-default',
            selectionLimit: 0,
            closeOnSelect: false,
            showCheckAll: false,
            showUncheckAll: false,
            dynamicTitleMaxItems: 3,
            maxHeight: '300px',
        };
        this.myTexts = {
            checkAll: 'Check all',
            uncheckAll: 'Uncheck all',
            checked: 'checked',
            checkedPlural: 'checked',
            searchPlaceholder: 'Search...',
            defaultTitle: 'Select',
        };
        this.scheduleSettings = {
            checkedStyle: 'glyphicon',
            selectionLimit: 1
        };
        this.loadingIndicator = false;
        this.schedule = new Schedule();
        this.schedules = [];
        this.budget = new Budget();
        this.budgets = [];
        this.hour = new Hour();
        this.hours = [];
        this.date = new Date().toLocaleDateString();
    }
    ContestComponent.prototype.onChange = function ($event, selectedOptions) {
        var _this = this;
        this.teacherOptions = this.myOptions.filter(function (item, index) {
            for (var i = 0, l = selectedOptions.length; i < l; i++) {
                if (selectedOptions[i] === item.id)
                    return true;
            }
            return false;
        });
        this.loadingIndicator = true;
        setTimeout(function () { _this.loadingIndicator = false; }, 1500);
    };
    ContestComponent.prototype.ngOnInit = function () {
    };
    ContestComponent.prototype.scheduleSelectedChange = function (teacherSelectedOption) {
    };
    ContestComponent.prototype.addSchedule = function (schedule) {
        this.schedules.push((new Schedule)
            .ScheduleId(schedule.scheduleId)
            .Content(schedule.content)
            .Position(schedule.position)
            .Date(schedule.date)
            .Hour(schedule.hour));
    };
    ContestComponent.prototype.addBudget = function (budget) {
        this.budgets.push((new Budget)
            .BudgetId(budget.budgetId)
            .Subject(budget.subject)
            .Sum(budget.sum)
            .Reasons(budget.reasons));
    };
    ContestComponent.prototype.addHour = function (hour) {
        this.hours.push((new Hour)
            .HoursId(hour.hoursId)
            .Type(hour.type)
            .Hour(hour.hours)
            .Remarks(hour.remarks));
    };
    return ContestComponent;
}());
ContestComponent = __decorate([
    Component({
        selector: 'app-contest',
        templateUrl: './contest.component.html',
        styleUrls: ['./contest.component.css']
    }),
    __metadata("design:paramtypes", [])
], ContestComponent);
export { ContestComponent };
//# sourceMappingURL=../../../../../src/app/contest/contest.component.js.map
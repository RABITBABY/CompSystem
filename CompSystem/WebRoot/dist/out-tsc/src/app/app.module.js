var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { MaterialModule } from '@angular/material';
import { MultiselectDropdownModule } from 'angular-2-dropdown-multiselect/src/multiselect-dropdown';
import { QuillModule } from 'ng2-quill/src/quill/quill.module';
import { Angular2DataTableModule } from 'angular2-data-table/src';
import { routing } from './app.routing';
import { AppComponent } from './app.component';
import { HomeComponent } from './home';
import { LoginComponent, LoginDialog } from './login';
var AppModule = (function () {
    function AppModule() {
    }
    return AppModule;
}());
AppModule = __decorate([
    NgModule({
        declarations: [
            AppComponent,
            LoginComponent, LoginDialog,
            HomeComponent
        ],
        entryComponents: [
            LoginDialog
        ],
        imports: [
            BrowserModule,
            FormsModule,
            HttpModule,
            routing,
            MaterialModule.forRoot(),
            MultiselectDropdownModule,
            QuillModule,
            Angular2DataTableModule
        ],
        providers: [],
        bootstrap: [AppComponent]
    }),
    __metadata("design:paramtypes", [])
], AppModule);
export { AppModule };
//# sourceMappingURL=../../../../src/app/app.module.js.map
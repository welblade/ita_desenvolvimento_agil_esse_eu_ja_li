import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ToolbarComponent} from "./toolbar.component";
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatListModule} from "@angular/material/list";
import {RouterModule} from "@angular/router";
@NgModule({
    declarations: [ToolbarComponent],
    imports: [
        CommonModule,
        RouterModule,
        MatToolbarModule,
        MatListModule,
    ],
    exports: [ToolbarComponent]
})
export class ToolbarModule {
}

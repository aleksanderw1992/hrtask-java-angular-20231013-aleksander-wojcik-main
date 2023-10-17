import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ComponentListComponent } from './app/components/component-list/component-list.component';
import { ComponentAddComponent } from './app/components/component-add/component-add.component';
import { ComponentDetailComponent } from './app/components/component-detail/component-detail.component';

@NgModule({
  declarations: [
    AppComponent,
    ComponentListComponent,
    ComponentAddComponent,
    ComponentDetailComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

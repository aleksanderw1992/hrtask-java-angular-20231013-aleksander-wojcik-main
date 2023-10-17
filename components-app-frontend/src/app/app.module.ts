import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { ComponentListComponent } from './components/component-list/component-list.component';
import { ComponentAddComponent } from './components/component-add/component-add.component';
import { ComponentDetailComponent } from './components/component-detail/component-detail.component';
import { ComponentService } from './services/component.service';

@NgModule({
  declarations: [
    AppComponent,
    ComponentListComponent,
    ComponentAddComponent,
    ComponentDetailComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [ComponentService],
  bootstrap: [AppComponent]
})
export class AppModule { }

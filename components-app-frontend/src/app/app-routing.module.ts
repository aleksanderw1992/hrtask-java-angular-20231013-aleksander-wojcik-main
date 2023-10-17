import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ComponentListComponent } from './components/component-list/component-list.component';
import { ComponentAddComponent } from './components/component-add/component-add.component';
import { ComponentDetailComponent } from './components/component-detail/component-detail.component';

const routes: Routes = [
  { path: '', redirectTo: '/components', pathMatch: 'full' },
  { path: 'components', component: ComponentListComponent },
  { path: 'components/add', component: ComponentAddComponent },
  { path: 'components/:id', component: ComponentDetailComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

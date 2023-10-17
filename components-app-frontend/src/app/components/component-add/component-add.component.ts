import { Component } from '@angular/core';
import { ComponentService } from '../../services/component.service';
import { ComponentModel } from '../../models/component.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-component-add',
  templateUrl: './component-add.component.html',
  styleUrls: ['./component-add.component.css']
})
export class ComponentAddComponent {

  newComponent: ComponentModel = {
    id: null,
    logo: '',
    name: '',
    description: ''
  };

  constructor(private componentService: ComponentService, private router: Router) { }

  addComponent(): void {
    this.componentService.addComponent(this.newComponent).subscribe(() => {
      this.router.navigate(['/components']);  // Redirect to the list after adding
    });
  }
}

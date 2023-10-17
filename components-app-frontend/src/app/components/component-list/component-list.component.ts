import { Component, OnInit } from '@angular/core';
import { ComponentService } from '../../services/component.service';
import { Observable } from 'rxjs';
import { ComponentModel } from '../../models/component.model';

@Component({
  selector: 'app-component-list',
  templateUrl: './component-list.component.html',
  styleUrls: ['./component-list.component.css']
})
export class ComponentListComponent implements OnInit {

  components$: Observable<ComponentModel[]>;

  constructor(private componentService: ComponentService) { }

  ngOnInit(): void {
    this.components$ = this.componentService.getComponents();
  }

  deleteComponent(id: number): void {
    this.componentService.deleteComponent(id).subscribe(() => {
      this.components$ = this.componentService.getComponents();  // Refresh the observable
    });
  }
}

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ComponentModel } from '../models/component.model';

@Injectable({
  providedIn: 'root'
})
export class ComponentService {
  private baseUrl = 'http://localhost:8080/api/components';

  constructor(private http: HttpClient) { }

  getComponents(): Observable<ComponentModel[]> {
    return this.http.get<ComponentModel[]>(this.baseUrl);
  }

  getComponent(id: number): Observable<ComponentModel> {
    return this.http.get<ComponentModel>(`${this.baseUrl}/${id}`);
  }

  addComponent(component: ComponentModel): Observable<ComponentModel> {
    return this.http.post<ComponentModel>(this.baseUrl, component);
  }

  deleteComponent(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }
}

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListTrofeuComponent } from './list-trofeu.component';

describe('ListTrofeuComponent', () => {
  let component: ListTrofeuComponent;
  let fixture: ComponentFixture<ListTrofeuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListTrofeuComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListTrofeuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

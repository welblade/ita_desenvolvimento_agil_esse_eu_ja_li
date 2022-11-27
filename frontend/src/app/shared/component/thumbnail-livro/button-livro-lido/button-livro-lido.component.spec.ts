import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ButtonLivroLidoComponent } from './button-livro-lido.component';

describe('ButtonLivroLidoComponent', () => {
  let component: ButtonLivroLidoComponent;
  let fixture: ComponentFixture<ButtonLivroLidoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ButtonLivroLidoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ButtonLivroLidoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

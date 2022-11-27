import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ThumbnailLivroComponent } from './thumbnail-livro.component';

describe('ThumbnailLivroComponent', () => {
  let component: ThumbnailLivroComponent;
  let fixture: ComponentFixture<ThumbnailLivroComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ThumbnailLivroComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ThumbnailLivroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

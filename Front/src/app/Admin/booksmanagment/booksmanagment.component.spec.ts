import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BooksmanagmentComponent } from './booksmanagment.component';

describe('BooksmanagmentComponent', () => {
  let component: BooksmanagmentComponent;
  let fixture: ComponentFixture<BooksmanagmentComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BooksmanagmentComponent]
    });
    fixture = TestBed.createComponent(BooksmanagmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

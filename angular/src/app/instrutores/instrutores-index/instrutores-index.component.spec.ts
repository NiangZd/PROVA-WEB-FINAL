import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstrutoresIndexComponent } from './instrutores-index.component';

describe('InstrutoresIndexComponent', () => {
  let component: InstrutoresIndexComponent;
  let fixture: ComponentFixture<InstrutoresIndexComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [InstrutoresIndexComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InstrutoresIndexComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

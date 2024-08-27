import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VerDadosComponent } from './ver-dados.component';

describe('VerDadosComponent', () => {
  let component: VerDadosComponent;
  let fixture: ComponentFixture<VerDadosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VerDadosComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VerDadosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

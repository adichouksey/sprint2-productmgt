import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductMgtComponent } from './product-mgt.component';

describe('ProductMgtComponent', () => {
  let component: ProductMgtComponent;
  let fixture: ComponentFixture<ProductMgtComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProductMgtComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductMgtComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

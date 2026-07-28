import { ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { SimpleChange } from '@angular/core';
import { provideMockStore, MockStore } from '@ngrx/store/testing';

import { CourseCardComponent } from './course-card';
import { Course } from '../../models/course.model';

import { vi } from 'vitest';

import {
  enrollInCourse
} from '../../store/enrollment/enrollment.actions';

describe('CourseCardComponent', () => {

  let component: CourseCardComponent;
  let fixture: ComponentFixture<CourseCardComponent>;
  let store: MockStore;

  const mockCourse: Course = {

    id: 1,
    name: 'Data Structures',
    code: 'CS101',
    credits: 4,
    gradeStatus: 'passed'

  };

  beforeEach(async () => {

    await TestBed.configureTestingModule({

      imports: [CourseCardComponent],
      providers: [
        provideMockStore()
      ]

    }).compileComponents();

    fixture = TestBed.createComponent(CourseCardComponent);

    component = fixture.componentInstance;

    store = TestBed.inject(MockStore);

  });

  // Test 1

  it('should create', () => {

    expect(component).toBeTruthy();

  });

  // Test 2

  it('should display course name', () => {

    component.course = mockCourse;

    fixture.detectChanges();

    const heading =
      fixture.debugElement.query(By.css('h2')).nativeElement;

    expect(heading.textContent).toContain('Data Structures');

  });

  // Test 3

  it('should display course code and credits', () => {

    component.course = mockCourse;

    fixture.detectChanges();

    const text =
      fixture.nativeElement.textContent;

    expect(text).toContain('CS101');

    expect(text).toContain('4');

  });

  // Test 4

  it('should dispatch enroll action when button is clicked', () => {

  component.course = mockCourse;

  fixture.detectChanges();

  vi.spyOn(store, 'dispatch');

  const button =
    fixture.debugElement.query(By.css('button')).nativeElement;

  button.click();

  expect(store.dispatch).toHaveBeenCalledWith(
    enrollInCourse({
      courseId: 1
    })
  );

});

  // Test 5

  it('should call console.log inside ngOnChanges', () => {

    vi.spyOn(console, 'log');

    component.course = mockCourse;

    component.ngOnChanges({

      course: new SimpleChange(

        null,

        mockCourse,

        true

      )

    });

    expect(console.log).toHaveBeenCalled();

  });

});
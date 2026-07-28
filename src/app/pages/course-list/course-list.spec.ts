import { ComponentFixture, TestBed } from '@angular/core/testing';
import { provideMockStore, MockStore } from '@ngrx/store/testing';
import { ActivatedRoute, Router } from '@angular/router';
import { vi } from 'vitest';
import { By } from '@angular/platform-browser';

import { CourseListComponent } from './course-list';

describe('CourseListComponent', () => {

  let component: CourseListComponent;
  let fixture: ComponentFixture<CourseListComponent>;
  let store: MockStore;
 let router: {
  navigate: ReturnType<typeof vi.fn>;
};
  const initialState = {

    course: {

      courses: [

        {
          id: 1,
          name: 'Angular',
          code: 'ANG101',
          credits: 4,
          gradeStatus: 'passed'
        },

        {
          id: 2,
          name: 'Java',
          code: 'JAVA201',
          credits: 3,
          gradeStatus: 'pending'
        }

      ],

      loading: false,

      error: null

    }

  };

  beforeEach(async () => {

   router = {
  navigate: vi.fn()
};

    await TestBed.configureTestingModule({

      imports: [

        CourseListComponent

      ],

      providers: [

        provideMockStore({

          initialState

        }),

        {

          provide: Router,

          useValue: router

        },

        {

          provide: ActivatedRoute,

          useValue: {

            snapshot: {

              queryParamMap: {

                get: () => ''

              }

            }

          }

        }

      ]

    }).compileComponents();

    store = TestBed.inject(MockStore);

    fixture = TestBed.createComponent(CourseListComponent);

    component = fixture.componentInstance;

    fixture.detectChanges();

  });

  it('should create', () => {

    expect(component).toBeTruthy();

  });

 it('should have courses from store', () => {

  component.courses$.subscribe(courses => {

    expect(courses.length).toBe(2);

    expect(courses[0].name).toBe('Angular');

  });

});

  it('should navigate when viewCourse is called', () => {

    component.viewCourse(1);

    expect(router.navigate).toHaveBeenCalledWith(['courses', 1]);

  });

  it('should update selectedCourseId', () => {

    component.onEnroll(2);

    expect(component.selectedCourseId).toBe(2);

  });

  it('should update search term', () => {

    component.searchTerm = 'Angular';

    expect(component.searchTerm).toBe('Angular');

  });

  it('should track course by id', () => {

    const course = {

  id:10,

  name:'Spring',

  code:'SPR101',

  credits:4,

  gradeStatus:'passed' as const

};

    expect(component.trackByCourseId(0, course)).toBe(10);

  });

  it('should change loading state', () => {

    store.setState({

      course: {

        courses: [],

        loading: true,

        error: null

      }

    });

    fixture.detectChanges();

    expect(component).toBeTruthy();

  });

});
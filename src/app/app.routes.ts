import { Routes } from '@angular/router';

import { HomeComponent } from './pages/home/home';
import { CourseListComponent } from './pages/course-list/course-list';
import { CourseDetailComponent } from './pages/course-detail/course-detail';
import { CoursesLayoutComponent } from './pages/courses-layout/courses-layout';
import { StudentProfileComponent } from './pages/student-profile/student-profile';
import { EnrollmentFormComponent } from './features/enrollment/enrollment-form/enrollment-form';
import { ReactiveEnrollmentComponent } from './features/enrollment/reactive-enrollment/reactive-enrollment';
import { NotFoundComponent } from './pages/not-found/not-found';

import { authGuard } from './guards/auth-guard';

export const routes: Routes = [

  {
    path: '',
    component: HomeComponent
  },

  {
    path: 'courses',
    component: CoursesLayoutComponent,
    children: [
      {
        path: '',
        component: CourseListComponent
      },
      {
        path: ':id',
        component: CourseDetailComponent
      }
    ]
  },

  {
    path: 'profile',
    canActivate: [authGuard],
    component: StudentProfileComponent
  },

  {
  path: 'enroll',
  canActivate: [authGuard],
  children: [
    {
      path: '',
      component: EnrollmentFormComponent
    },
    {
      path: 'reactive',
      component: ReactiveEnrollmentComponent
    }
  ]
},

  {
    path: '**',
    component: NotFoundComponent
  }

];
import { ApplicationConfig } from '@angular/core';
import { provideRouter } from '@angular/router';
import { provideHttpClient, withInterceptors } from '@angular/common/http';
import { errorHandlerInterceptor } from './interceptors/error-handler-interceptor';
import { loadingInterceptor } from './interceptors/loading-interceptor';
import { provideStore } from '@ngrx/store';
import { provideStoreDevtools } from '@ngrx/store-devtools';
import { provideState } from '@ngrx/store';
import { provideEffects } from '@ngrx/effects';
import { CourseEffects } from './store/course/course.effects';
import { courseReducer } from './store/course/course.reducer';
import { enrollmentReducer } from './store/enrollment/enrollment.reducer';
import { authInterceptor } from './interceptors/auth-interceptor';

import { routes } from './app.routes';

export const appConfig: ApplicationConfig = {

  providers: [

  provideRouter(routes),

  provideHttpClient(

    withInterceptors([
      authInterceptor,
      errorHandlerInterceptor,
      loadingInterceptor
    ])

  ),

  provideStore(),

  provideState(
    'course',
    courseReducer
  ),

  provideState(
  'enrollment',
  enrollmentReducer
),

 
  provideStoreDevtools({
    maxAge: 25
  })

]

};
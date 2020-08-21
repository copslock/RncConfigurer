import {Injectable} from '@angular/core';
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {Observable} from 'rxjs';
import { CookieService } from 'ngx-cookie-service';

@Injectable()
export class LoginIntercept implements HttpInterceptor {
  constructor(private cookie: CookieService ) { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    // if (this.cookie.get('JSESSIONID')) {
    req = req.clone({
      setHeaders: {
        Cookie: 'asdsadsad'
      }
    });
    //  }

    return next.handle(req);
  }
}

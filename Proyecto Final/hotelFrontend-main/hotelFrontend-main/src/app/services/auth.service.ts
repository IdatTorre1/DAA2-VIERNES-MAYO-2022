import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
//import { NuevoUsuario } from '../models/nuevo-usuario';
import { Observable } from 'rxjs';
import { LoginUsuario } from '../models/login-usuario';
import { JwtDTO } from '../models/jwt-dto';
import { environment } from './../../environments/environment';
import { Persona } from '../models/persona';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  authURL = environment.authURL;

  constructor(private httpClient: HttpClient) {}

  public login(loginUsuario: LoginUsuario): Observable<JwtDTO> {
    return this.httpClient.post<JwtDTO>(this.authURL + 'login', loginUsuario);
  }

  public refresh(dto: JwtDTO): Observable<JwtDTO> {
    return this.httpClient.post<JwtDTO>(this.authURL + 'refresh', dto);
  }
}

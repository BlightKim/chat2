import {IUser} from "@/models/user";

export interface AuthResponse {
  user: IUser;
  token: string;
}
import {ComponentType} from "react";
import {AppBar} from "@mui/material";
import HomePage from "@/pages/home-page";
import SignupPage from "@/pages/signup-page";
import LoginPage from "src/pages/login-page";

export enum Paths {
    HOME = "/",
    SIGNUP = "/signup",
    LOGIN = "/login",
    PROFILE = "/profile",
    ROOMS = "/rooms",
    ROOM = "/rooms/:id",
    ADD_ROOM = "/rooms/add",
    UPDATE_ROOM = "/rooms/:id/update",
}

export interface IRoute {
    path: Paths;
    Component: ComponentType;
}

export const publicRoutes: IRoute[] = [
    { path: Paths.HOME, Component: HomePage },
    { path: Paths.SIGNUP, Component: SignupPage},
    { path: Paths.LOGIN, Component: LoginPage},
];

export const authRoutes: IRoute[] = [
];
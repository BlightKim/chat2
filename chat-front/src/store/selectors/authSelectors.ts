import {RootState} from "@/store";

export const getAuthState = (state: RootState) => state.auth;
export const getDrawerState = (state: RootState) => state.drawer;
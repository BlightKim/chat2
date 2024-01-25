import {createSlice} from "@reduxjs/toolkit";
import {IUser} from "@/models/user";

export interface AuthState {
    isAuth: boolean;
    token: string | null;
    user: IUser | null;
}

const initialState: AuthState = {
    isAuth: false,
    token: null,
    user: null,
}
export const authSlice = createSlice({
    name: "auth",
    initialState,
    reducers: {
        logout: (state) => {
            state.isAuth = false;
            state.token = null;
            // socketService.disconnect();
        }
    }
})
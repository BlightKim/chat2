import {combineReducers, configureStore} from "@reduxjs/toolkit";
import {authSlice} from "@/store/slices/authSlice";
import {drawerSlice} from "@/store/slices/drawerSlice";

const rootReducer = combineReducers({
    auth: authSlice.reducer,
    drawer: drawerSlice.reducer,
});

export const setupStore = () => configureStore({
    reducer: rootReducer,
})


export const store = setupStore();
export type RootState = ReturnType<typeof rootReducer>;
export type AppStore = ReturnType<typeof setupStore>;
export type AppDispatch = AppStore["dispatch"];

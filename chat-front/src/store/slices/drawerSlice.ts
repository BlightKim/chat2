import {IUser} from "@/models/user";
import {createSlice} from "@reduxjs/toolkit";

export interface DrawerState {
  isOpen: boolean;
}

const initialState: DrawerState = {
  isOpen: false,
}

export const drawerSlice = createSlice({
  name: "drawer",
  initialState,
  reducers: {
    toggle: (state) => {
      state.isOpen = !state.isOpen;
    }
  }
})
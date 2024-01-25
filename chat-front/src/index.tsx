import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import App from "./App";
import reportWebVitals from "./reportWebVitals";
import { BrowserRouter } from "react-router-dom";
import {createTheme, StyledEngineProvider, ThemeProvider} from "@mui/material";
import { Provider } from "react-redux";
import {store} from "@/store";

const root = ReactDOM.createRoot(
  document.getElementById("root") as HTMLElement,
);

const defaultTheme = createTheme();
root.render(
  <React.StrictMode>
    <Provider store={store}>
      <BrowserRouter>
        <ThemeProvider theme={defaultTheme}>
          <App />
        </ThemeProvider>
      </BrowserRouter>
    </Provider>
  </React.StrictMode>,
);


import * as yup from "yup";

export interface EnvironmentVariables
  extends yup.InferType<typeof configValidationSchema> {}

export const configValidationSchema = yup.object({
  VITE_API_BASE_URL: yup.string().required(),
  VITE_API_SOCKET_URL: yup.string().required(),
  VITE_API_SIGNUP_URL: yup.string().required(),
});

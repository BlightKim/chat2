import {object, string, TypeOf, ZodSchema} from "zod";
import {TextFieldProps} from "@mui/material";

const loginSchema = object({
  email: string().min(1, '이메일을 입력해주세요.').email('유효한 이메일 형식이 아닙니다.'),
  password: string()
  .min(1, '비밀번호를 입력해주세요')
});

// 👇 Type of Props the FormInput will receive
export type FormInputProps = {
  name: string;
} & TextFieldProps;

export type ILogin = TypeOf<typeof loginSchema>

export function getLoginSchema(): ZodSchema<ILogin> {
  return loginSchema;
}
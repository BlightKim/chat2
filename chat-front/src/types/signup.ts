import {boolean, literal, object, string, TypeOf, ZodSchema} from "zod";
import {TextFieldProps} from "@mui/material";

const signupSchema = object({
  email: string().min(1, '이메일을 입력해주세요').email('이메일 형식이 유효하지 않습니다.'),
  name: string().min(1, '이름을 입력해주세요.'),
  password: string()
  .min(1, '비밀번호는 필수 값입니다.'),
  passwordConfirm: string()
  .min(1, '확인 비밀번호는 필수 값입니다.'),
  agreePolicy: boolean().refine(value => value, '정책에 동의해야 합니다.'),

}).refine(data => data.password === data.passwordConfirm, {
  message: "비밀번호와 확인 비밀번호가 일치하지 않습니다.",
  path: ["passwordConfirm"]
})

export type ISignup = TypeOf<typeof signupSchema>

export function getSignupSchema():ZodSchema<ISignup> {
  return signupSchema;
}
import React, {FC} from "react";
import {TextField, TextFieldProps} from "@mui/material";
import {useFormContext} from "react-hook-form";

type FormFieldsProps = { name: string } & TextFieldProps;
const FormField: FC<FormFieldsProps> = ({name, label, ...textFieldProps}) => {

  const {
    register,
    formState: {errors},
  } = useFormContext();

  return (
      <TextField
          label={label}
          {...register(name)}
          error={!!errors[name]}
          helperText={errors[name]?.message as string}
          {...textFieldProps}
      />
  );
}

export default FormField;
import React, {FC} from "react";
import {Button, Typography} from "@mui/material";
import {Link} from "react-router-dom";
import {Paths} from "@/routes";

const SignupLink: FC = () => {
  return (
      <Typography variant="body1">
        Don't you have an account? {" "}
        <Button component={Link} to={Paths.SIGNUP}>
          Signup
        </Button>
      </Typography>
  );
}

export default SignupLink;
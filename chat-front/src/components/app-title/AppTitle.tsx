import React, {FC} from "react";
import {Typography} from "@mui/material";
import classes from "./AppTitle.module.scss"
import {NavLink} from "react-router-dom";
import {Paths} from "@/routes";

const AppTitle: FC = () => {
    return (
        <Typography
            variant="h1"
            className={classes.title}
            component={NavLink}
            to={Paths.HOME}
        >
            React Chat

        </Typography>
    )
}

export default AppTitle;
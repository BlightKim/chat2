import React, {FC, useState} from "react";
import {AppBar, Stack} from "@mui/material";
import classes from "./Header.module.scss"
import AppTitle from "@/components/app-title/AppTitle";

const Header: FC = () => {
    const [menuIsOpen, setMenuIsOpen] = useState(false);

    return (
        <AppBar className={classes.header} data-testid="header">
            <Stack direction="row" classes={classes.container}>
                <AppTitle />
            </Stack>
        </AppBar>
    )
}

export default Header;
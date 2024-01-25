import {IUser} from "@/models/user";

export interface IMessage {
    id: number;
    owner: IUser;
    roomId: number;
    content: string;
}

export interface AddMessageDto {
    roomId: number,
    content: string,
}
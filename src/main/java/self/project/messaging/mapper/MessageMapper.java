package self.project.messaging.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import self.project.messaging.dto.MessageDto;
import self.project.messaging.model.Message;

@Mapper
public interface MessageMapper {
    MessageMapper INSTANCE = Mappers.getMapper(MessageMapper.class);

    @Mapping(target = "content", source = "text")
    @Mapping(target = "sender", source = "sender.username")
    @Mapping(target = "type", expression = "java(self.project.messaging.dto.MessageType.CHAT)")
    @Mapping(target = "sent", source = "sent")
    @Mapping(target = "chatId", source = "chat.id")
    MessageDto toDto(Message message);
}
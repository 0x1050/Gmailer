# Gmailer
Simple Windows command line batch Gmailer written in Java.

---

## Notes
- You must enable access for less secure apps in Gmail account settings to use this
- This program was written to handle the sending of emails for my Photobomb scripts. It can be used with any program that can create a folder with attachments. It will work so long as the name of the folder(s) matches a valid email pattern.
- Depends on javax.jar

## Files

| File             | Purpose                                                                                                                                                              |
| ----             | -------                                                                                                                                                              |
| Choices.java     | Simply asks to send a specific email or all                                                                                                                          |
| Count.java       | A silly countdown that informs the user that the program will shut down in 10 seconds. I thought it looked cool                                                      |
| Directory.java   | Directory listing and modification helper functions. `dirLister` depends on IsEmail.java to populate an array of subfolders whose name match an email regex pattern. |
| email.bat        | Invocation script that adds the classpath to supplementary jar files                                                                                                 |
| email.cmd        | Same as email.bat.... redundant                                                                                                                                      |
| EmailFuncts.java | Creates an email with attachments to send with Gmail. Reads subject and body text from emailSubject.txt and                                                          |
| Email.java       | Creates a Gmail session to send emails. Depends on javax.jar                                                                                                         |
| IsEmail.java     | Regex pattern recognition for email addresses.                                                                                                                       |
| SendEmail.java   | Program entry point, presents user with a menu, or notifies that there are no emails to send                                                                         |
| Streams.java     | Reads file streams                                                                                                                                                   |
| Discount.jpg     | Create a marketing image and it is placed as the first attachment                                                                                                    |

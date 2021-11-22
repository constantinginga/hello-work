using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Diagnostics.CodeAnalysis;
using System.Linq;
using System.Threading.Tasks;

namespace WebApplication.Models
{
    public class Application
    {
        public Application()
        {
            Status = Status.Waiting;
        }

        public int JobId { get; set; }
        [Required] public string Details { get; set; }
        public string employeEmail { get; set; }
        public string employerEmail { get; set; }
        public Status Status { get; set; }
        public Dictionary<string, string> Files { get; set; }

        public void SetFile(string fileName, Byte[] file)
        {
            Files.Add(fileName, System.Text.Encoding.UTF8.GetString(file));
        }

        public Byte[] GetFile(string fileName)
        {
            return System.Text.Encoding.UTF8.GetBytes(Files[fileName]);
        }
    }
}